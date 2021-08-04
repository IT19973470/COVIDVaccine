import {Component, Input, OnInit} from '@angular/core';
import {VaccineMapService} from "../_service/vaccine-map.service";
import {DatePipe} from "@angular/common";

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

  place;
  vaccine;
  date;
  time;

  constructor(private vaccineMapService: VaccineMapService, private datePipe: DatePipe) {
  }

  ngOnInit(): void {
    this.getVaccines()
  }

  setPlace(placeId) {
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
}
