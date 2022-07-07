import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TrainbookingComponent } from './trainbooking.component';

describe('TrainbookingComponent', () => {
  let component: TrainbookingComponent;
  let fixture: ComponentFixture<TrainbookingComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ TrainbookingComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(TrainbookingComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
