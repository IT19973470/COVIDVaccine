import {Component, OnInit} from '@angular/core';
import {Router} from "@angular/router";
import {ItemService} from "../item.service";

@Component({
  selector: 'app-nav',
  templateUrl: './nav.component.html',
  styleUrls: ['./nav.component.css']
})
export class NavComponent implements OnInit {

  itemCount = 0;

  constructor(private router: Router, private itemService: ItemService) {
    this.itemService.itemCount.subscribe((itemCount) => {
      this.itemCount = itemCount;
    })
  }

  ngOnInit(): void {
  }

}
