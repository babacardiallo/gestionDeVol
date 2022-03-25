import {AfterViewInit, ChangeDetectionStrategy, Component, Input, OnInit} from '@angular/core';
import {VolDisplayed} from "../../models/vol-displayed";
import {ColumnDef} from "../../models/column-def";
import {Router} from "@angular/router";

@Component({
  selector: 'data-table',
  templateUrl: './data-table.component.html',
  styleUrls: ['./data-table.component.scss']
})
export class DataTableComponent implements OnInit, AfterViewInit{

  @Input() dataSource: VolDisplayed[]  = [];

  @Input() columns: ColumnDef[] = [];

  @Input() displayedColumns: any;

  constructor(private router: Router) {
  }

  ngAfterViewInit() {
  }

  ngOnInit(): void {
  }

  navigateToDetail(ev: any){
    this.router.navigate(['/vol', ev.indentifiant]);
  }




}

