import {Component, Input, OnInit} from '@angular/core';
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
  @Input() patients;
  @Input() subDivisionId;

  place;
  // vaccine;
  date;
  time;

  vaccineToken = {
    tokenId: '',
    subDivisionOfficer: {
      subDivisionOfficerId: {
        officerId: 'O1',
        subDivisionId: 'Rathgama'
      },
      officer: {
        officerId: 'O1'
      },
      subDivision: {
        subDivisionId: 'Rathgama'
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
  }

  constructor(private vaccineMapService: VaccineMapService, private datePipe: DatePipe, private patientService: PatientService) {
  }

  ngOnInit(): void {
    this.getVaccines()
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

  setTokenType(tokenType) {
    this.vaccineToken.tokenType = tokenType;
    this.vaccineMapService.getPlacesWIthPatients(this.subDivisionId, tokenType).subscribe((placesPatients) => {
      this.places = placesPatients.places;
      this.patients = placesPatients.patients;
      console.log(this.patients)
    })
  }

  addVaccineToken(patient, index) {
    this.vaccineToken.patient.patientId = patient.patientId;
    this.vaccineToken.tokenDateTime = this.date + 'T' + this.time;
    this.vaccineToken.tokenId = this.vaccineToken.patient.patientId + this.vaccineToken.place.placeId + this.vaccineToken.tokenDateTime + this.vaccineToken.tokenType
    this.patientService.addVaccineToken(this.vaccineToken).subscribe((patient) => {
      // this.vaccineToken.patient.patientId = patientId;
      // console.log(this.patients[this.patients.indexOf(patient)])
      this.patients[index].tokenId = patient.tokenId;
      this.patients[index].vaccine = patient.vaccine;
      this.patients[index].place = patient.place;
      this.patients[index].registered = true;
    })
  }

  removeVaccineToken(patient, index) {
    this.patientService.removeVaccineToken(patient.tokenId).subscribe((patientId) => {
      this.patients[index].registered = false;
    })
  }
}
