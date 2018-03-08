import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { IngredientsViewerComponent } from './ingredients-viewer.component';

describe('IngredientsViewerComponent', () => {
  let component: IngredientsViewerComponent;
  let fixture: ComponentFixture<IngredientsViewerComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ IngredientsViewerComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(IngredientsViewerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component)
      .toBeTruthy();
  });
});
