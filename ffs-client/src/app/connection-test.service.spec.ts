import { TestBed, inject } from '@angular/core/testing';

import { ConnectionTestService } from './connection-test.service';

describe('ConnectionTestService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [ConnectionTestService]
    });
  });

  it('should be created', inject([ConnectionTestService], (service: ConnectionTestService) => {
    expect(service).toBeTruthy();
  }));
});
