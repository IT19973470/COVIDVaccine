import {Component, OnInit} from '@angular/core';

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

  constructor() {
  }

  ngOnInit(): void {
  }

  isTrueOrFalse(reply) {
    this.isModalTable.openTable = reply;
  }
}
