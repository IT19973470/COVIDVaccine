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
  subDivision;
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
  patient = {
    firstName: '',
    lastName: '',
    contactNumber: '',
    address: ''
  };
  selectedArea = '';

  // @ViewChild('manageVehicle') manageVehicle;

  constructor(private vaccineMapService: VaccineMapService, private patientService: PatientService) {
    // super();
    // this.handler = this.handler.bind(this);
    this.state = {selectedDistrict: ''};
  }

  ngOnInit(): void {
  }

  islandWideVaccine() {
    this.district = undefined;
    this.totalRegistrationsFirst = 0;
    this.totalRegistrationsSecond = 0;
    this.vaccineMapService.getVaccinatedCountForIslandWide().subscribe((placesPatients) => {
      this.subDivisions = placesPatients.subDivisions;
      this.subDivisionVaccinesFirst = placesPatients.vaccinesFirst;
      this.subDivisionVaccinesSecond = placesPatients.vaccinesSecond;
      for (let vaccine of placesPatients.vaccinesFirst) {
        this.totalRegistrationsFirst += vaccine.registered;
      }
      for (let vaccine of placesPatients.vaccinesSecond) {
        this.totalRegistrationsSecond += vaccine.registered;
      }
      if (this.subDivisions.length === 0) {
        this.subDivisionVaccinesFirst = [];
        this.subDivisionVaccinesSecond = [];
      }
      this.subDivisions.sort((a, b) => (a.registered > b.registered) ? -1 : ((b.registered > a.registered) ? 1 : 0))
    })
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
    // console.log(district)
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
      if (this.subDivisions.length === 0) {
        this.subDivisionVaccinesFirst = [];
        this.subDivisionVaccinesSecond = [];
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
    this.patientService.getMyVaccines(nic).subscribe((patient) => {
      if (patient !== null) {
        this.patient = patient;
        for (let i = 0; i < patient.vaccines.length; i++) {
          console.log(patient.vaccines[i])
          if (patient.vaccines[i].tokenType === 1) {
            this.vaccines[0] = patient.vaccines[i];
          } else if (patient.vaccines[i].tokenType === 2) {
            this.vaccines[1] = patient.vaccines[i];
          }
        }
      }
      // console.log(this.vaccines)
    })
  }

  validateUser() {
    return localStorage.getItem('user') !== null;
  }

  getUser() {
    return JSON.parse(localStorage.getItem('user'));
  }

  logout() {
    localStorage.clear();
  }
}
