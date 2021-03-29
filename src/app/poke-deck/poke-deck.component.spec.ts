import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PokeDeckComponent } from './poke-deck.component';

describe('PokeDeckComponent', () => {
  let component: PokeDeckComponent;
  let fixture: ComponentFixture<PokeDeckComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PokeDeckComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(PokeDeckComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
