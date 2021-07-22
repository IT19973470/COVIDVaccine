import {Injectable} from '@angular/core';
import {Subject} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class ItemService {

  itemCountTemp=0;
  itemCount = new Subject<number>();

  constructor() {
  }
}
