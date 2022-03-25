import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {FormControl} from "@angular/forms";

@Component({
  selector: 'app-date-filter',
  templateUrl: './date-filter.component.html',
  styleUrls: ['./date-filter.component.scss']
})
export class DateFilterComponent implements OnInit {

  myControl = new FormControl();

  @Input() label: string | undefined;

  @Input() id: string | undefined ;

  @Output() valueChange: EventEmitter<any> = new EventEmitter<any>();

  constructor() {
    this.myControl.valueChanges.subscribe(value => {
      this.valueChange.emit([this.id, value]);
    })
  }

  ngOnInit(): void {
  }

}
