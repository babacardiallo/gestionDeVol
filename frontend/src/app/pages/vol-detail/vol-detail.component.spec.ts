import { ComponentFixture, TestBed } from '@angular/core/testing';

import { VolDetailComponent } from './vol-detail.component';

describe('VolDetailComponent', () => {
  let component: VolDetailComponent;
  let fixture: ComponentFixture<VolDetailComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ VolDetailComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(VolDetailComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
