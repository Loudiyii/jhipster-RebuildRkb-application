import { TestBed } from '@angular/core/testing';

import { ProjectgeneratorService } from './projectgenerator.service';

describe('ProjectgeneratorService', () => {
  let service: ProjectgeneratorService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ProjectgeneratorService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
