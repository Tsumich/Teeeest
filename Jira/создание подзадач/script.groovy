import com.atlassian.jira.component.ComponentAccessor
import com.atlassian.jira.issue.Issue
import com.atlassian.jira.issue.IssueInputParametersImpl

final newLabel = 'create_subtask'

def myissue = event.issue
if (!myissue.subTask && newLabel in myissue.labels*.label) {
    createSubtask(myissue)
}

def createSubtask(Issue parentIssue) {
    def subTaskManager = ComponentAccessor.subTaskManager
    def asUser = ComponentAccessor.jiraAuthenticationContext.loggedInUser
    def constantsManager = ComponentAccessor.constantsManager
    def issueService = ComponentAccessor.issueService

    def subtaskIssueType = constantsManager.allIssueTypeObjects.findByName('Sub-task')

    assert subtaskIssueType?.subTask

    // Fill the required fields
    def issueInputParameters = new IssueInputParametersImpl()
    issueInputParameters
            .setProjectId(parentIssue.projectId)
            .setIssueTypeId(subtaskIssueType.id)
            .setSummary('A new subtask')
            .setDescription('A description')
            .setReporterId(asUser.username)

    def createValidationResult = ComponentAccessor.issueService.validateSubTaskCreate(asUser, parentIssue.id, issueInputParameters)
    if (!createValidationResult.valid) {
        log.error createValidationResult.errorCollection
        return
    }

    def newIssue = issueService.create(asUser, createValidationResult).issue
    subTaskManager.createSubTaskIssueLink(parentIssue, newIssue, asUser)
}