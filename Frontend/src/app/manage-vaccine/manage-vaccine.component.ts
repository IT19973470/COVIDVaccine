import {Component, OnInit} from '@angular/core';
import {VaccineMapService} from "../_service/vaccine-map.service";

@Component({
  selector: 'app-manage-vaccine',
  templateUrl: './manage-vaccine.component.html',
  styleUrls: ['./manage-vaccine.component.css']
})
export class ManageVaccineComponent implements OnInit {

  isModalTable = {
    text: '',
    openTable: false,
    foundItem: ''
  };
  vaccines;

  constructor(private vaccineMapService: VaccineMapService) {
  }

  ngOnInit(): void {
    this.getVaccines()
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
