import { TestBed, inject } from '@angular/core/testing';

import { ClienthttpService } from './clienthttp.service';

describe('ClienthttpService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [ClienthttpService]
    });
  });

  it('should be created', inject([ClienthttpService], (service: ClienthttpService) => {
    expect(service).toBeTruthy();
  }));
});
