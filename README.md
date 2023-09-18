# codemaker-pull-request-action-example

Example of [codemaker-pull-request-action](https://github.com/codemakerai/codemaker-pull-request-action)

### Requirements

Requirements: give workflow write access to your repo: Under repo Settings -> Actions -> General -> Workflow permissions, make sure "Read and write permissions" is selected.

### Caveat

Due to the limitation of Github workflow, there is no good way to handle concurrent run. This is especially because that the comment line number is an import parameter for CodeMaker processor to perform generation. Since the line number is determined when ```pull_request_review_comment``` web hook event is triggerred, multiple concurrent workflow trigger will cause the line number to be outdated because some other runs may have already updated the file content.

Because of this limitation, it is important to post PR comment one by one, and do not post a new one until the workflow run triggerred by the previous one has completed.
