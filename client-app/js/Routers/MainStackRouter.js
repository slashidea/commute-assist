import { StackNavigator } from 'react-navigation';
import Login from '../components/login/';
import Home from '../components/home/';
import BlankPage from '../components/blankPage';
import HomeDrawerRouter from './HomeDrawerRouter';

HomeDrawerRouter.navigationOptions = () => ({
  header: null,
});

export default StackNavigator({ // eslint-disable-line
  Login: { screen: Login },
  Home: { screen: Home },
  BlankPage: { screen: BlankPage },
});
