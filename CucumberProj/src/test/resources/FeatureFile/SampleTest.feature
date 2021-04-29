@TechExam2
Feature: Validates manage settings functionality

  @UpdateAllSettings
  Scenario Outline: Update my amaysim settings
    Given chrome browser is open
    When user access my account page with "<amaysimNo>","<amaysimPw>"
    And user navigates to settings page
    And update sim nickname with "<simNickname>"
    And update recharge pin with "<rechargepin>"
    And update caller id settings "<callId>"
    #And update call waiting settings
    #And update voicemail settings
    #And update usage alerts settings
    #And update international romaing settings
    #And update call forwarding option
    #And update premium sms limit option
    #And update auto credit top up option
    Then all changes should work as expected

    Examples: 
      | amaysimNo  | amaysimPw | simNickname | rechargepin | callId |
      | 0481862258 | theHoff34 | AliasSim    |        9876 | no     |

  @Callforwarding
  Scenario Outline: Add/Remove Call forwarding opting
    Given chrome browser is open
    When user access my account page with "<amaysimNo>","<amaysimPw>"
    And user navigates to settings page
    And updates call forwarding option
      | callFwd   | fwdTo   |
      | <callFwd> | <fwdTo> |
    Then all changes should work as expected

    Examples: 
      | amaysimNo  | amaysimPw | callFwd | fwdTo      |
      | 0481862258 | theHoff34 | yes     | 0412345679 |
      #| 0481862258 | theHoff34 | no      |            |
