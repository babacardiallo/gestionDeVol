import {Component, OnInit} from '@angular/core';
import {VolDisplayed} from "../../models/vol-displayed";
import {VolService} from "../../cores/services/vol.service";
import {map} from "rxjs";
import {VolSearchFilter} from "../../models/vol-search-filter";
import {DATE_ARRIVE, DATE_DEPART, LIEU_ARRIVE, LIEU_DEPART} from "../../cores/constant/app.cst";

@Component({
  selector: 'app-vol',
  templateUrl: './vol.component.html',
  styleUrls: ['./vol.component.scss']
})
export class VolComponent implements OnInit{

  autoSuggestId = [
    {id: 'lieuDepart', label: 'Lieu depart'},
    {id: 'lieuArrive', label: 'Destination'}
  ];
  dateId = [
    {id: 'dateDepart', label: 'Date depart'},
    {id: 'dateArrive', label: 'Date arrivee'}
  ];

  dataSource: VolDisplayed[]  = [];

  volSearchParam: VolSearchFilter  = {
    pageDto : {
      pageNumber: 0,
      pageSize: 100
    }
  };

  columns = this.volService.executeAction();

  displayedColumns = this.columns.map(c => c.columnDef);

  constructor(private volService: VolService) {
  }

  ngOnInit(): void {
    this.lauchFilter();
  }

  updateAuSuggest(value: any){
    if(value[0] === LIEU_DEPART) {
      if(value[1] === ''){
        delete this.volSearchParam.lieuDepart;
      } else {
        this.volSearchParam.lieuDepart = value[1];
      }
    }
    if(value[0] === LIEU_ARRIVE) {
      if(value[1] === ''){
        delete this.volSearchParam.lieuArrive;
      } else {
        this.volSearchParam.lieuArrive = value[1];

      }
    }
  }

  updateDate(value: any){
    if(value[0] === DATE_DEPART) {
      this.volSearchParam.dateDepart = value[1];
    }
    if(value[0] === DATE_ARRIVE) {
      this.volSearchParam.dateArrive = value[1];
    }
  }

  lauchFilter() {
    this.volService.getAllVol(this.volSearchParam).pipe(
      map(vol => this.volService.convertToDisplayVol(vol))
    )
      .subscribe(res => {
        this.dataSource = res;
      });
  }

}
