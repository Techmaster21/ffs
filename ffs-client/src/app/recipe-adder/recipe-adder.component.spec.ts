import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { RecipeAdderComponent } from './recipe-adder.component';

describe('RecipeAdderComponent', () => {
  let component: RecipeAdderComponent;
  let fixture: ComponentFixture<RecipeAdderComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ RecipeAdderComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(RecipeAdderComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
