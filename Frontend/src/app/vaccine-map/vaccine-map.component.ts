import {Component, OnInit, ViewChild} from '@angular/core';
import '../../assets/map/map.js';
import '../../assets/map/jquery.min';
import {VaccineMapService} from "../_service/vaccine-map.service";
import {PatientService} from "../_service/patient.service";

declare var slMap: any;

@Component({
  selector: 'app-vaccine-map',
  templateUrl: './vaccine-map.component.html',
  styleUrls: ['./vaccine-map.component.css']
})

export class VaccineMapComponent implements OnInit {

  state;
  district;
  province;
  subDivisions = [];
  // places = [];
  patients = [];
  subDivisionId;
  subDivisionVaccinesFirst = [];
  subDivisionVaccinesSecond = [];
  totalRegistrationsFirst = 0;
  totalRegistrationsSecond = 0;
  vaccines = [
    {
      tokenDateTimeFormattedDate: 'N/A',
      tokenDateTimeFormattedTime: 'N/A',
      place: {
        placeName: 'N/A'
      },
      vaccine: {
        vaccineName: 'N/A'
      }
    },
    {
      tokenDateTimeFormattedDate: 'N/A',
      tokenDateTimeFormattedTime: 'N/A',
      place: {
        placeName: 'N/A'
      },
      vaccine: {
        vaccineName: 'N/A'
      }
    }
  ];

  // @ViewChild('manageVehicle') manageVehicle;

  constructor(private vaccineMapService: VaccineMapService, private patientService: PatientService) {
    // super();
    // this.handler = this.handler.bind(this);
    this.state = {selectedDistrict: ''};
  }

  ngOnInit(): void {
  }

  getPlaces(subDivisionId) {
    this.vaccineMapService.subDivisionId = subDivisionId;
    this.subDivisionId = subDivisionId;
    this.totalRegistrationsFirst = 0;
    this.totalRegistrationsSecond = 0;
    this.vaccineMapService.getPlacesWIthPatients(subDivisionId, 1).subscribe((placesPatients) => {
      // this.places = placesPatients.places;
      // this.manageVehicle.setTokenType(1);
      this.subDivisionVaccinesFirst = placesPatients.vaccinesFirst;
      this.subDivisionVaccinesSecond = placesPatients.vaccinesSecond;
      for (let vaccine of placesPatients.vaccinesFirst) {
        this.totalRegistrationsFirst += vaccine.registered;
      }
      for (let vaccine of placesPatients.vaccinesSecond) {
        this.totalRegistrationsSecond += vaccine.registered;
      }
      // console.log(placesPatients.vaccines)
    })
  }

  setDistrict(districtId, district, province) {
    this.district = district;
    this.province = province;
    this.vaccineMapService.getVaccinatedCountForSubDivision(districtId).subscribe((subDivisions) => {
      this.subDivisions = subDivisions;
      // console.log(subDivisions)
    })
  }

  getMyVaccines(nic) {
    this.vaccines = [
      {
        tokenDateTimeFormattedDate: 'N/A',
        tokenDateTimeFormattedTime: 'N/A',
        place: {
          placeName: 'N/A'
        },
        vaccine: {
          vaccineName: 'N/A'
        }
      },
      {
        tokenDateTimeFormattedDate: 'N/A',
        tokenDateTimeFormattedTime: 'N/A',
        place: {
          placeName: 'N/A'
        },
        vaccine: {
          vaccineName: 'N/A'
        }
      }
    ];
    this.patientService.getMyVaccines(nic).subscribe((vaccines) => {
      for (let i = 0; i < vaccines.length; i++) {
        console.log(vaccines[i])
        if (vaccines[i].tokenType === 1) {
          this.vaccines[0] = vaccines[i];
        } else if (vaccines[i].tokenType === 2) {
          this.vaccines[1] = vaccines[i];
        }
      }
      // console.log(this.vaccines)
    })
  }

  validateUser() {
    return localStorage.getItem('user') !== null;
  }

  logout() {
    localStorage.clear();
  }
}
