import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {LieuService} from "../../../cores/services/lieu.service";
import {FormControl} from "@angular/forms";

@Component({
  selector: 'app-auto-suggest',
  templateUrl: './auto-suggest.component.html',
  styleUrls: ['./auto-suggest.component.scss']
})
export class AutoSuggestComponent implements OnInit {

  myControl = new FormControl();

  options: string[] = [];

  @Input() label: string | undefined;

  @Input() id: string | undefined ;

  @Output() valueChange: EventEmitter<any> = new EventEmitter<any>();

  constructor(private lieuService: LieuService) {

    this.myControl.valueChanges.subscribe(value => {
      this.valueChange.emit([this.id, value]);
    })
  }

  ngOnInit(): void {
    this.lieuService.getAllLieu().subscribe((res: string[]) => {
      this.options = res;
    });
  }

}
