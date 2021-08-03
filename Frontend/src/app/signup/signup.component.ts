import {Component, Input, OnInit, Output, EventEmitter} from '@angular/core';
import {VaccineMapService} from "../_service/vaccine-map.service";

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

  constructor(private vaccineMapService: VaccineMapService) {
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

  // changeVal(txt){
  //   this.stNameChange.emit(txt)
  // }
}
