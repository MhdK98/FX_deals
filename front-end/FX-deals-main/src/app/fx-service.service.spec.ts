import { TestBed } from '@angular/core/testing';

import { FxServiceService } from './fx-service.service';

describe('FxServiceService', () => {
  let service: FxServiceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(FxServiceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
