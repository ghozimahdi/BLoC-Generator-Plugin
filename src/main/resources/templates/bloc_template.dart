import 'package:flutter_bloc/flutter_bloc.dart';
import 'package:freezed_annotation/freezed_annotation.dart';
import 'package:injectable/injectable.dart';

part '{{name}}_bloc.freezed.dart';
part '{{name}}_event.dart';
part '{{name}}_state.dart';

@injectable
class {{Name}}Bloc extends Bloc<{{Name}}Event, {{Name}}State> {
  {{Name}}Bloc() : super(const {{Name}}State.idle()) {
    on<_InitEvent>(_initEvent);
  }

  Future<void> _initEvent(
    _InitEvent event,
    Emitter<{{Name}}State> emit,
  ) async {}
}
