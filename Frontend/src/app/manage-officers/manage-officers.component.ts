import {Component, OnInit} from '@angular/core';
import {VaccineMapService} from "../_service/vaccine-map.service";
import {LoginService} from "../_service/login.service";


@Component({
  selector: 'app-manage-officers',
  templateUrl: './manage-officers.component.html',
  styleUrls: ['./manage-officers.component.css']
})
export class ManageOfficersComponent implements OnInit {

  officers = [];
  officerObj = {
    officerId: '',
    firstName: '',
    lastName: ''
  };
  tblIndex;
  isAdding = true;

  constructor(private loginService: LoginService) {
  }

  ngOnInit(): void {
    this.getOfficers();
  }

  addOfficer() {
    this.loginService.addOfficer(this.officerObj).subscribe((officer) => {
      this.officers.push(officer);
      this.newOfficer();
    })
  }

  updateOfficer() {
    this.loginService.updateOfficer(this.officerObj.officerId, this.officerObj).subscribe((officer) => {
      if (officer !== null) {
        this.officers[this.tblIndex] = officer;
        this.newOfficer();
      }
    })
  }

  removeOfficer() {
    this.loginService.removeOfficer(this.officerObj.officerId).subscribe((officer) => {
      if (officer) {
        this.officers.splice(this.tblIndex, 1);
        this.newOfficer();
      }
    })
  }

  getOfficers() {
    this.loginService.getOfficers().subscribe((officers) => {
      this.officers = officers;
      // console.log(this.places)
    })
  }

  newOfficer() {
    this.isAdding = true;
    this.officerObj = {
      officerId: '',
      firstName: '',
      lastName: ''
    };
  }

  setOfficer(officer) {
    this.isAdding = false;
    this.officerObj.officerId = officer.officerId;
    this.officerObj.firstName = officer.firstName;
    this.officerObj.lastName = officer.lastName;
  }

}
