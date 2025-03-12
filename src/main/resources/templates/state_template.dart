part of '{{name}}_bloc.dart';

@freezed
class {{Name}}State with _${{Name}}State {
  const factory {{Name}}State.idle() = {{Name}}IdleState;
  const factory {{Name}}State.done() = {{Name}}DoneState;
}