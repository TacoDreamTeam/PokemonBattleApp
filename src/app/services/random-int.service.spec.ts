import { TestBed } from '@angular/core/testing';

import { RandomIntService } from './random-int.service';

describe('RandomIntService', () => {
  let service: RandomIntService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(RandomIntService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
