import { Component, OnInit } from '@angular/core';
import {VaccineMapService} from "./vaccine-map.service";
import {environment} from "../../environments/environment";

@Component({
  selector: 'app-vaccine-map',
  templateUrl: './vaccine-map.component.html',
  styleUrls: ['./vaccine-map.component.scss'],
})
export class VaccineMapComponent implements OnInit {

  subDivision;
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

  selectedArea = '';

  // @ViewChild('manageVehicle') manageVehicle;

  constructor(private vaccineMapService: VaccineMapService) {
    // super();
    // this.handler = this.handler.bind(this);
    this.state = {selectedDistrict: ''};
  }

  ngOnInit(): void {
  }

  getPlaces(subDivision) {
    this.selectedArea = subDivision.subDivisionName;
    this.vaccineMapService.subDivision = subDivision;
    this.subDivision = subDivision;
    this.totalRegistrationsFirst = 0;
    this.totalRegistrationsSecond = 0;
    this.vaccineMapService.getPatientsCountForPlace(subDivision.subDivisionId, 1).subscribe((placesPatients) => {
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
    this.selectedArea = district;
    this.district = district;
    this.province = province;
    this.totalRegistrationsFirst = 0;
    this.totalRegistrationsSecond = 0;
    this.vaccineMapService.getVaccinatedCountForSubDivision(districtId).subscribe((placesPatients) => {
      this.subDivisions = placesPatients.subDivisions;
      this.subDivisionVaccinesFirst = placesPatients.vaccinesFirst;
      this.subDivisionVaccinesSecond = placesPatients.vaccinesSecond;
      for (let vaccine of placesPatients.vaccinesFirst) {
        this.totalRegistrationsFirst += vaccine.registered;
      }
      for (let vaccine of placesPatients.vaccinesSecond) {
        this.totalRegistrationsSecond += vaccine.registered;
      }
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
    this.vaccineMapService.getMyVaccines(nic).subscribe((vaccines) => {
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

  getEnv(){
    return environment.backend_url
  }
}
