import {Component, OnInit} from '@angular/core';
import {VaccineMapService} from "../_service/vaccine-map.service";

@Component({
  selector: 'app-manage-places',
  templateUrl: './manage-places.component.html',
  styleUrls: ['./manage-places.component.css']
})
export class ManagePlacesComponent implements OnInit {

  subDivision;
  places = [];
  placeObj = {
    placeId: 'N/A',
    placeName: '',
    address: '',
    subDivision: {
      subDivisionId: ''
    }
  };
  tblIndex;

  constructor(private vaccineMapService: VaccineMapService) {
  }

  ngOnInit(): void {
    this.subDivision = this.vaccineMapService.subDivision;
    this.getPlaces();
  }

  addPlace() {
    this.placeObj.subDivision = this.subDivision;
    this.vaccineMapService.addPlace(this.placeObj).subscribe((place) => {
      this.places.push(place);
      this.newPlace();
    })
  }

  updatePlace() {
    this.vaccineMapService.updatePlace(this.placeObj.placeId, this.placeObj).subscribe((place) => {
      if (place !== null) {
        this.places[this.tblIndex] = place;
        this.newPlace();
      }
    })
  }

  removePlace() {
    this.vaccineMapService.removePlace(this.placeObj.placeId).subscribe((place) => {
      if (place) {
        this.places.splice(this.tblIndex, 1);
        this.newPlace();
      }
    })
  }

  getPlaces() {
    this.vaccineMapService.getPlaces(this.subDivision.subDivisionId).subscribe((places) => {
      this.places = places;
      // console.log(this.places)
    })
  }

  newPlace() {
    this.placeObj = {
      placeId: 'N/A',
      placeName: '',
      address: '',
      subDivision: {
        subDivisionId: ''
      }
    };
  }

  setPlace(place) {
    this.placeObj.placeId = place.placeId;
    this.placeObj.placeName = place.placeName;
    this.placeObj.address = place.address;
  }
}
