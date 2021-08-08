import {Component, OnInit} from '@angular/core';
import {VaccineMapService} from "../_service/vaccine-map.service";

@Component({
  selector: 'app-manage-vaccines',
  templateUrl: './manage-vaccines.component.html',
  styleUrls: ['./manage-vaccines.component.css']
})
export class ManageVaccinesComponent implements OnInit {

  vaccines = [];
  vaccineObj = {
    vaccineId: 'N/A',
    vaccineName: ''
  };
  tblIndex;

  constructor(private vaccineMapService: VaccineMapService) {
  }

  ngOnInit(): void {
    this.getVaccines();
  }

  addVaccine() {
    this.vaccineMapService.addVaccine(this.vaccineObj).subscribe((vaccine) => {
      this.vaccines.push(vaccine);
      this.newVaccine();
    })
  }

  updateVaccine() {
    this.vaccineMapService.updateVaccine(this.vaccineObj.vaccineId, this.vaccineObj).subscribe((vaccine) => {
      if (vaccine !== null) {
        this.vaccines[this.tblIndex] = vaccine;
        this.newVaccine();
      }
    })
  }

  removeVaccine() {
    this.vaccineMapService.removeVaccine(this.vaccineObj.vaccineId).subscribe((vaccine) => {
      if (vaccine) {
        this.vaccines.splice(this.tblIndex, 1);
        this.newVaccine();
      }
    })
  }

  getVaccines() {
    this.vaccineMapService.getVaccines().subscribe((vaccines) => {
      this.vaccines = vaccines;
      // console.log(this.places)
    })
  }

  newVaccine() {
    this.vaccineObj = {
      vaccineId: 'N/A',
      vaccineName: ''
    };
  }

  setVaccine(vaccine) {
    this.vaccineObj.vaccineId = vaccine.vaccineId;
    this.vaccineObj.vaccineName = vaccine.vaccineName;
  }
}
