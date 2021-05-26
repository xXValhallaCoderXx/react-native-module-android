import React from 'react';
import {
  SafeAreaView,
  ScrollView,
  StatusBar,
  Button,
  View,
  Text,
  NativeModules,
} from 'react-native';

import {Colors, Header} from 'react-native/Libraries/NewAppScreen';
const {OurModule} = NativeModules;

const App = () => {
  const onPress = () => {
    OurModule.openToast('Hello Java from JS');
  };

  const onHeavyCompute = async () => {
    try {
      const result = await OurModule.heavyCalculation(5, 5);
      OurModule.openToast(result);
    } catch (e) {
      console.log('Error: ', e);
    }
  };
  return (
    <SafeAreaView style={Colors.darker}>
      <StatusBar barStyle="light-content" />
      <ScrollView
        contentInsetAdjustmentBehavior="automatic"
        style={Colors.darker}>
        <Header />
        <View
          style={{
            backgroundColor: Colors.black,
          }}>
          <Button title="OPEN TOAST" onPress={onPress} />
          <Button title="HEAVY COMPUTE" onPress={onHeavyCompute} />
        </View>
      </ScrollView>
    </SafeAreaView>
  );
};

export default App;
