import {Component, Input, OnInit, Output, EventEmitter} from '@angular/core';
import {VaccineMapService} from "../_service/vaccine-map.service";
import {PatientService} from "../_service/patient.service";

// import * as EventEmitter from "events";

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent implements OnInit {

  // @Input() stName;
  // @Output() stNameChange = new EventEmitter<string>();
  // myStName;
  provinces;
  districts;
  subDivisions;
  vaccines;
  patient;
  success = 0;

  constructor(private vaccineMapService: VaccineMapService, private patientService: PatientService) {
    this.patient = this.getPatient();
  }

  ngOnInit(): void {
    this.getProvinces();
    this.getVaccines();
  }

  getProvinces() {
    this.vaccineMapService.getProvinces().subscribe((provinces) => {
      this.provinces = provinces;
    })
  }

  getDistricts(provinceId) {
    this.vaccineMapService.getDistricts(provinceId).subscribe((districts) => {
      this.districts = districts;
    })
  }

  getSubDivisions(placeId) {
    this.vaccineMapService.getSubDivisions(placeId).subscribe((subDivisions) => {
      this.subDivisions = subDivisions;
    })
  }

  getVaccines() {
    this.vaccineMapService.getVaccines().subscribe((vaccines) => {
      this.vaccines = vaccines;
    })
  }

  onSubmit() {
    this.patientService.addPatient(this.patient).subscribe((patient) => {
      this.patient.patientId = patient.patientId;
      this.success = 1;
    }, (error) => {
      this.success = 2;
    })
  }

  getPatient() {
    return {
      patientId: '',
      firstName: '',
      lastName: '',
      dateOfBirth: '',
      contactNumber: '',
      address: '',
      subDivision: {
        subDivisionId: ''
      },
      vaccine: {
        vaccineId: ''
      }
    }
  }

  // changeVal(txt){
  //   this.stNameChange.emit(txt)
  // }
}
