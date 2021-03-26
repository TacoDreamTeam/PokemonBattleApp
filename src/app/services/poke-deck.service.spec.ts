import { TestBed } from '@angular/core/testing';

import { PokeDeckService } from './poke-deck.service';

describe('PokeDeckService', () => {
  let service: PokeDeckService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(PokeDeckService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
