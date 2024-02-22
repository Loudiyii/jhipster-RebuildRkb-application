import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ProjectgeneratorComponent } from './projectgenerator.component';

describe('ProjectgeneratorComponent', () => {
  let component: ProjectgeneratorComponent;
  let fixture: ComponentFixture<ProjectgeneratorComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ProjectgeneratorComponent],
    }).compileComponents();

    fixture = TestBed.createComponent(ProjectgeneratorComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
