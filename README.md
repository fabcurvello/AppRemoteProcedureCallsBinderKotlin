# App Remote Procedure Calls com Binder (Kotlin)

> Repositório didático: exercício prático de Android nativo com **Kotlin**, desenvolvido e aplicado em sala de aula pelo Prof. Fabricio Curvello.

## Sobre o projeto

Aplicativo que demonstra a comunicação entre uma Activity e um **Service vinculado (Bound Service)** por meio de um `Binder`.

## Contexto acadêmico

Exercício aplicado em sala de aula, usado como prática guiada com os alunos.

## Versão em Java

Esta mesma aplicação também foi desenvolvida em **Java**: [AppRemoteProcedureCallsBinderJava](https://github.com/fabcurvello/AppRemoteProcedureCallsBinderJava). Comparar as duas versões lado a lado ajuda a entender as diferenças de sintaxe entre Java e Kotlin no Android.

## O que o app faz

- A Activity se vincula ao `MyService` em `onStart()` e se desvincula em `onStop()`.
- Ao tocar no botão, chama diretamente um método do serviço (`getMessage()`), que devolve uma mensagem com um contador.
- A resposta do serviço aparece na tela.

## Conceitos trabalhados em aula

- **Bound Services** (`bindService` / `unbindService`)
- Comunicação Activity ↔ Service com `Binder` e `IBinder`
- `ServiceConnection` (`onServiceConnected` / `onServiceDisconnected`)
- Chamada de procedimentos no serviço (RPC local)
- `inner class` e operador de chamada segura (`?.`) em Kotlin

## Tecnologias

- **Kotlin**
- **Android SDK** (Android Studio)
- **Gradle**
- `minSdk 28` / `compileSdk 34`

## Como executar

1. Clone o repositório:
   ```bash
   git clone https://github.com/fabcurvello/AppRemoteProcedureCallsBinderKotlin.git
   ```
2. Abra a pasta no **Android Studio** e aguarde a sincronização do Gradle.
3. Execute em um emulador ou dispositivo físico com Android compatível com a API 28 ou superior.

## Veja também

Outros repositórios de aula com o mesmo tema:

- [AppServicesJava](https://github.com/fabcurvello/AppServicesJava)
- [AppServicesKotlin](https://github.com/fabcurvello/AppServicesKotlin)
- [AppRemoteProcedureCallsBinderJava](https://github.com/fabcurvello/AppRemoteProcedureCallsBinderJava)
- [AppThreadJava](https://github.com/fabcurvello/AppThreadJava)
- [AppThreadKotlin](https://github.com/fabcurvello/AppThreadKotlin)

## Autor

**Fabricio Curvello**: professor de desenvolvimento de software no SENAI-RJ (desde 1997) e em faculdades do grupo Ânima Educação (IBMR e UNA).

- GitHub: [github.com/fabcurvello](https://github.com/fabcurvello)
- LinkedIn: [linkedin.com/in/fabriciocurvello](https://www.linkedin.com/in/fabriciocurvello)
- YouTube: [@fabriciocurvello](https://www.youtube.com/@fabriciocurvello)
