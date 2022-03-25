import { NgModule } from '@angular/core';
import {DataTableComponent} from "./data-table/data-table.component";
import {DateFilterComponent} from "./fields/date-filter/date-filter.component";
import {AutoSuggestComponent} from "./fields/auto-suggest/auto-suggest.component";
import {MatTableModule} from '@angular/material/table';
import {MatPaginatorModule} from "@angular/material/paginator";
import {MatSortModule} from "@angular/material/sort";
import {CommonModule} from "@angular/common";
import {MatAutocompleteModule} from '@angular/material/autocomplete';
import {ReactiveFormsModule} from "@angular/forms";
import {MatInputModule} from "@angular/material/input";
import {MatDatepickerModule} from "@angular/material/datepicker";
import {MatNativeDateModule} from "@angular/material/core";
import {MatButtonModule} from "@angular/material/button";
import { VolDetailComponent } from '../pages/vol-detail/vol-detail.component';
import {MatCardModule} from "@angular/material/card";
import {MatBadgeModule} from "@angular/material/badge";
import {RouterModule} from "@angular/router";

@NgModule({
  declarations: [
    DataTableComponent,
    DateFilterComponent,
    AutoSuggestComponent,
    VolDetailComponent
  ],
  imports: [
    MatTableModule,
    MatPaginatorModule,
    MatSortModule,
    CommonModule,
    MatAutocompleteModule,
    ReactiveFormsModule,
    MatInputModule,
    MatDatepickerModule,
    MatNativeDateModule,
    MatButtonModule,
    MatCardModule,
    MatBadgeModule,
    RouterModule
  ],
  providers: [],
  exports: [
    DataTableComponent,
    AutoSuggestComponent,
    DateFilterComponent,
    VolDetailComponent
  ]
})
export class LayoutModule { }
