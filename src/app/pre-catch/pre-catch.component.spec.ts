import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PreCatchComponent } from './pre-catch.component';

describe('PreCatchComponent', () => {
  let component: PreCatchComponent;
  let fixture: ComponentFixture<PreCatchComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PreCatchComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(PreCatchComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
