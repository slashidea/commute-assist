import React, { Component, PropTypes } from 'react';
import { AsyncStorage } from 'react-native';
import { DrawerNavigator, NavigationActions } from 'react-navigation';
import {
  Container,
  Header,
  Title,
  Content,
  Text,
  Button,
  Icon,
  Left,
  Body,
  Right,
} from 'native-base';
import { Grid, Row } from 'react-native-easy-grid';
import BlankPage2 from '../blankPage2';
import DrawBar from '../DrawBar';
import styles from './styles';

let DrawerNav = null;

class Home extends Component {
  static navigationOptions = {
    header: null,
  };
  static propTypes = {
    navigation: PropTypes.shape({
      navigate: PropTypes.func.isRequired,
    }).isRequired,
  };
  constructor() {
    super();
    this.state = { list: ['first', 'second', 'third'] };
  }
  render() {
    return (
      <Container style={styles.container}>
        <Header>
          <Left>
            <Button
              transparent
              onPress={() => {
                AsyncStorage.removeItem('employeeId').then(() => {
                  DrawerNav.dispatch(
                    NavigationActions.reset({
                      index: 0,
                      actions: [NavigationActions.navigate({ routeName: 'Home' })],
                    })
                  );
                  DrawerNav.goBack();
                });
              }}
            >
              <Icon active name="power" />
            </Button>
          </Left>
          <Body>
            <Title>Home</Title>
          </Body>
          <Right>
            <Button
              transparent
              onPress={() => DrawerNav.navigate('DrawerOpen')}
            >
              <Icon active name="menu" />
            </Button>
          </Right>
        </Header>
        <Content>
          <Grid style={styles.mt}>
            {this.state.list.map((item, i) => (
              <Row key={i}>
                <Button
                  bordered
                  style={styles.row}
                  onPress={() =>
                    this.props.navigation.navigate('BlankPage', { name: { item } })
                  }
                >
                  <Text style={styles.text}>{item}</Text>
                </Button>
              </Row>
            ))}
          </Grid>
        </Content>
      </Container>
    );
  }
}

const DrawNav = DrawerNavigator( // eslint-disable-line
  {
    Home: { screen: Home },
    BlankPage2: { screen: BlankPage2 },
  },
  {
    contentComponent: props => <DrawBar {...props} />,
  }
);

DrawNav.navigationOptions = ({ navigation }) => {
  DrawerNav = navigation;
  return {
    header: null,
  };
};

export default DrawNav;
