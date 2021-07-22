import {Component, OnInit} from '@angular/core';
import {ItemService} from "../item.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-cont',
  templateUrl: './cont.component.html',
  styleUrls: ['./cont.component.css']
})
export class ContComponent implements OnInit {

  itemCount = 0;
  student = {
    firstName: '',
    lastName: ''
  };
  val=0;

  constructor(private router: Router, private itemService: ItemService) {
  }

  ngOnInit(): void {
    // this.custName = this.itemServie.custName;
  }

  goToNav() {
    this.itemService.itemCount.next(++this.itemService.itemCountTemp)
    // this.router.navigate(['/cont']);
  }

  onSubmit() {
    console.log(this.student)
  }
}
