import {Component, OnInit} from '@angular/core';
import '../../assets/map/map.js';
import '../../assets/map/jquery.min';
import {VaccineMapService} from "../_service/vaccine-map.service";

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
  places = [];

  constructor(private vaccineMapService: VaccineMapService) {
    // super();
    // this.handler = this.handler.bind(this);
    this.state = {selectedDistrict: ''};
  }

  ngOnInit(): void {
  }

  getPlaces(subDivisionId) {
    this.vaccineMapService.getPlacesWIthPatients(subDivisionId).subscribe((places) => {
      this.places = places;
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
}
