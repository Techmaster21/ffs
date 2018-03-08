import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { RecipesViewerComponent } from './recipes-viewer.component';

describe('RecipesViewerComponent', () => {
  let component: RecipesViewerComponent;
  let fixture: ComponentFixture<RecipesViewerComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ RecipesViewerComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(RecipesViewerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component)
      .toBeTruthy();
  });
});
