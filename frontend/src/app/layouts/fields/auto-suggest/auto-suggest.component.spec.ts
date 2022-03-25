import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AutoSuggestComponent } from './auto-suggest.component';

describe('AutoSuggestComponent', () => {
  let component: AutoSuggestComponent;
  let fixture: ComponentFixture<AutoSuggestComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AutoSuggestComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AutoSuggestComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
