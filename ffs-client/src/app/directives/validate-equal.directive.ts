import { Directive, Input } from '@angular/core';
import { AbstractControl, NG_VALIDATORS, Validator, ValidatorFn } from '@angular/forms';

/** A hero's name can't match the given regular expression */
export function ValidateEqual(otherPassName: string): ValidatorFn {
  return (control: AbstractControl): { [key: string]: any } => {
    const password = control.value;
    const otherPass = control.root.get(otherPassName).value;

    return password !== otherPass ? {validateEqual: {value: control.value}} : undefined;
  };
}

@Directive({
  selector: '[appValidateEqual]',
  providers: [{provide: NG_VALIDATORS, useExisting: ValidateEqualDirective, multi: true}]
})
export class ValidateEqualDirective implements Validator {
  @Input('appValidateEqual') appValidateEqual: string;

  validate(control: AbstractControl): { [key: string]: any } {
    return ValidateEqual(this.appValidateEqual)(control);
  }

}
