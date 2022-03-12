import { TestBed } from '@angular/core/testing';

import { FaixaetariaService } from './faixaetaria.service';

describe('FaixaetariaService', () => {
  let service: FaixaetariaService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(FaixaetariaService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
