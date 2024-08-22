import 'package:flutter/material.dart';
import 'package:flutter_exemplo1/custom_button.dart';
import 'package:flutter_gen/gen_l10n/app_localizations.dart';

class MyHomePage extends StatefulWidget {
  const MyHomePage({super.key, required this.title});

  final String title;

  @override
  State<MyHomePage> createState() => _MyHomePageState();
}

class _MyHomePageState extends State<MyHomePage> {
  // Atributos que guardam estado
  int _counter = 0;

  void _incrementCounter() {
    print("Clicked in the button!! $_counter");
    setState(() {
      _counter++;
    });
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        backgroundColor: Theme.of(context).colorScheme.inversePrimary,
        title: Text(widget.title),
      ),
      body: Center(
        child: Column(
          mainAxisAlignment: MainAxisAlignment.center,
          children: <Widget>[
            Text(
              'I go first!',
              style: Theme.of(context).textTheme.bodyLarge,
            ),
            const SizedBox(height: 30,),
            const Text(
              'You have pushed the button this many times:',
            ),
            Text(
              '$_counter',
              style: Theme.of(context).textTheme.headlineMedium,
            ),
          CustomButton(
              text: AppLocalizations.of(context)!.clickMe,
              padding: 50,
              iconData: Icons.access_alarm,
              spaceBetween: 10,
              callback: _incrementCounter
          ),
            CustomButton(
              text: 'Click Me Again!',
              padding: 50,
              iconData: Icons.adb,
              spaceBetween: 10,
              callback: _incrementCounter
          ),
          ],
        ),
      ),
      floatingActionButton: FloatingActionButton(
        onPressed: _incrementCounter,
        tooltip: 'Increment',
        child: const Icon(Icons.add),
      ),
    );
  }
}