import {Component, OnInit} from '@angular/core';
import {VaccineMapService} from "../_service/vaccine-map.service";
import {LoginService} from "../_service/login.service";

@Component({
  selector: 'app-main-officer',
  templateUrl: './main-officer.component.html',
  styleUrls: ['./main-officer.component.css']
})
export class MainOfficerComponent implements OnInit {

  subDivision;
  places;
  officers;
  subDivisionOfficers = [];
  place;
  officerId;
  tblIndex;

  constructor(private vaccineMapService: VaccineMapService, private loginService: LoginService) {
  }

  ngOnInit(): void {
    this.subDivision = this.vaccineMapService.subDivision;
    this.getPlaces();
    this.getSubDivisionOfficers();
    this.getOfficersForSubDivision(this.subDivision.subDivisionId);
  }

  getPlaces() {
    this.vaccineMapService.getPlaces(this.subDivision.subDivisionId).subscribe((places) => {
      this.places = places;
      // console.log(this.patients)
    })
  }

  getSubDivisionOfficers() {
    this.vaccineMapService.getSubDivisionOfficers().subscribe((officers) => {
      this.officers = officers;
      // console.log(this.patients)
    })
  }

  getOfficersForSubDivision(placeId) {
    this.vaccineMapService.getOfficersForSubDivision(placeId).subscribe((subDivisionOfficers) => {
      this.subDivisionOfficers = subDivisionOfficers;
      // console.log(this.patients)
    })
  }

  // setPlace(placeId) {
  //   // this.vaccineToken.place.placeId = placeId;
  //   if (placeId !== '') {
  //     this.getOfficersForSubDivision(placeId);
  //   }
  //   this.place = this.places.filter(place => {
  //     return place.placeId === placeId
  //   })[0]['placeName']
  // }

  setOfficer(officerId) {
    this.officerId = officerId;
    // this.officer = this.officers.filter(officer => {
    //   return officer.officerId === officerId
    // })[0]['placeName']
  }

  addOfficer() {
    let subDivisionOfficer = {
      subDivision: {
        subDivisionId: this.subDivision.subDivisionId
      },
      officer: {
        officerId: this.officerId
      }
    };
    this.loginService.addSubDivisionOfficer(subDivisionOfficer).subscribe((subDivisionOfficer) => {
      console.log(subDivisionOfficer)
      this.subDivisionOfficers.push(subDivisionOfficer.officer);
    })
  }

  removeOfficer(officerId, tblIndex) {
    this.loginService.removeSubDivisionOfficer(this.subDivision.subDivisionId, officerId).subscribe((subDivisionOfficer) => {
      this.subDivisionOfficers.splice(tblIndex, 1);
    })
  }
}
