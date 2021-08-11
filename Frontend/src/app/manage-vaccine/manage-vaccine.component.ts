import {Component, Input, OnInit, ViewChild} from '@angular/core';
import {VaccineMapService} from "../_service/vaccine-map.service";
import {DatePipe} from "@angular/common";
import {PatientService} from "../_service/patient.service";

@Component({
  selector: 'app-manage-vaccine',
  templateUrl: './manage-vaccine.component.html',
  styleUrls: ['./manage-vaccine.component.css'],
  providers: [DatePipe]
})
export class ManageVaccineComponent implements OnInit {

  isModalTable = {
    text: '',
    openTable: false,
    foundItem: ''
  };
  vaccines;
  @Input() places;
  patients = [];
  subDivision;

  place;
  // vaccine;
  date;
  time;
  age = 10;
  success = 0;

  vaccineToken = {
    tokenId: '',
    subDivisionOfficer: {
      subDivisionOfficerId: {
        officerId: '',
        subDivisionId: ''
      },
      officer: {
        officerId: ''
      },
      subDivision: {
        subDivisionId: ''
      }
    },
    patient: {
      patientId: ''
    },
    place: {
      placeId: ''
    },
    vaccine: {
      vaccineId: ''
    },
    tokenDateTime: '',
    tokenType: 1
  };

  constructor(private vaccineMapService: VaccineMapService, private datePipe: DatePipe, private patientService: PatientService) {
  }

  ngOnInit(): void {
    this.subDivision = this.vaccineMapService.subDivision;
    // console.log(this.subDivisionId)
    this.getVaccines();
    this.getPlaces();
    this.setTokenType(1)
  }

  setPlace(placeId) {
    this.vaccineToken.place.placeId = placeId;
    this.place = this.places.filter(place => {
      return place.placeId === placeId
    })[0]['placeName']
  }

  setTime() {
    return this.datePipe.transform(new Date(this.date + 'T' + this.time), 'hh:mm a')
  }

  getVaccines() {
    this.vaccineMapService.getVaccines().subscribe((vaccines) => {
      this.vaccines = vaccines;
    })
  }

  isTrueOrFalse(reply) {
    this.isModalTable.openTable = reply;
  }

  getPlaces() {
    this.vaccineMapService.getPlaces(this.subDivision.subDivisionId).subscribe((places) => {
      this.places = places;
      // console.log(this.patients)
    })
  }

  setTokenType(tokenType) {
    this.vaccineToken.tokenType = tokenType;
    this.vaccineMapService.getPatientsForPlace(this.subDivision.subDivisionId, tokenType, this.age).subscribe((patients) => {
      // this.places = placesPatients.places;
      this.patients = patients;
      // console.log(this.patients)
    })
  }

  getByAge(age) {
    this.age = age;
    this.vaccineMapService.getPatientsForPlace(this.subDivision.subDivisionId, this.vaccineToken.tokenType, this.age).subscribe((patients) => {
      // this.places = placesPatients.places;
      this.patients = patients;
      // console.log(this.patients)
    })
  }

  addVaccineToken(patient, index) {
    this.vaccineToken.patient.patientId = patient.patientId;
    this.vaccineToken.tokenDateTime = this.date + 'T' + this.time;
    this.vaccineToken.tokenId = this.vaccineToken.patient.patientId + this.vaccineToken.tokenType;
    this.vaccineToken.subDivisionOfficer.subDivision.subDivisionId = this.subDivision.subDivisionId;
    this.vaccineToken.subDivisionOfficer.officer.officerId = JSON.parse(localStorage.getItem('user'))['userNic'];

    this.patientService.addVaccineToken(this.vaccineToken).subscribe((patient) => {
      // this.vaccineToken.patient.patientId = patientId;
      // console.log(this.patients[this.patients.indexOf(patient)])
      this.patients[index].tokenId = patient.tokenId;
      this.patients[index].vaccine = patient.vaccine;
      this.patients[index].place = patient.place;
      this.patients[index].registered = true;
      this.success = 1;
    }, (error) => {
      this.success = 2;
    })
  }

  removeVaccineToken(patient, index) {
    this.patientService.removeVaccineToken(patient.tokenId).subscribe((patientId) => {
      this.patients[index].registered = false;
    })
  }
}
