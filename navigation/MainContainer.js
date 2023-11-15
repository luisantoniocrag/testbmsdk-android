import React from 'react';

import { NavigationContainer } from '@react-navigation/native';
import { createBottomTabNavigator } from '@react-navigation/bottom-tabs';
import Ionicons from 'react-native-vector-icons/Ionicons';

import HomeScreen from './screens/HomeScreen';
import EventsScreen from './screens/EventsScreen';
import OrdersScreen from './screens/OrdersScreen';
import AuthScreen from './screens/AuthScreen';

const homeName = "Home";
const eventsName = "Events";
const ordersName = "Orders";
const authName = "Auth";

const Tab = createBottomTabNavigator();

export default function MainConteiner() {
    return (
        <NavigationContainer>
            <Tab.Navigator 
                initialRouteName={homeName}
                screenOptions={
                    ({route}) => ({
                        tabBarIcon: ({ focused, color, size }) => {
                            let iconName;
                            let rn = route.name;

                            if (rn === homeName) {
                                iconName = focused ? 'home' : 'home-outline'
                            } else if (rn === eventsName) {
                                iconName = focused ? 'calendar' : 'calendar-outline'
                            } else if (rn === ordersName) {
                                iconName = focused ? 'wallet' : 'wallet-outline'
                            } else if (rn === authName) {
                                iconName = focused ? 'person' : 'person-outline'
                            }                
                            
                            return <Ionicons name={iconName} size={size} color={color} />
                        },
                    })}>
                
                <Tab.Screen name={homeName} component={HomeScreen} />
                <Tab.Screen name={eventsName} component={EventsScreen} options={{ headerShown: false }}  />
                <Tab.Screen name={ordersName} component={OrdersScreen} options={{ headerShown: false }} />
                <Tab.Screen name={authName} component={AuthScreen} options={{ headerShown: false }} />

            </Tab.Navigator>
        </NavigationContainer>
    )
}