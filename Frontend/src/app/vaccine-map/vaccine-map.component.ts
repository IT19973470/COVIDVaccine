import {Component, OnInit} from '@angular/core';
import '../../assets/map/map.js';
import '../../assets/map/jquery.min';

declare var slMap:any;

@Component({
  selector: 'app-vaccine-map',
  templateUrl: './vaccine-map.component.html',
  styleUrls: ['./vaccine-map.component.css']
})

export class VaccineMapComponent implements OnInit {

  state;

  constructor() {
    // super();
    // this.handler = this.handler.bind(this);
    this.state = {selectedDistrict: ''};
  }

  ngOnInit(): void {
  }


}
