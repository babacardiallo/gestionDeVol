import { Component, OnInit } from '@angular/core';
import {ActivatedRoute} from "@angular/router";
import {VolService} from "../../cores/services/vol.service";
import {Vol} from "../../models/vol";

@Component({
  selector: 'app-vol-detail',
  templateUrl: './vol-detail.component.html',
  styleUrls: ['./vol-detail.component.scss']
})
export class VolDetailComponent implements OnInit {

  detail: Vol  = {};

  escale = '';

  constructor(private activatedRoute: ActivatedRoute, private volService: VolService) { }

  ngOnInit(): void {
    const id = this.activatedRoute.snapshot.params['id'];
    this.volService.getVolById(id).subscribe(vol => {
      this.detail = vol;
      vol.escales?.forEach(el => {
        if(this.escale === ''){
          this.escale += el.lieuEscale;
        } else {
          this.escale += ' ---> ' + el.lieuEscale;
        }
      })
    })
  }

}
