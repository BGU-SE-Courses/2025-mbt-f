# Paths
$serverFolder = "C:\Users\Denis\Documents\GitHub\2025-mbt-f\Provengo\Moodle\server"                 # moodle server folder
$moodleDataFolder = "C:\Users\Denis\Documents\GitHub\2025-mbt-f\Provengo\Moodle\server\moodledata"  # moodledata folder
$mysqlFolder = "C:\Users\Denis\Documents\GitHub\2025-mbt-f\Provengo\Moodle\server\mysql"            # mysql folder
$backupFolder = "C:\Users\Denis\Documents\GitHub\2025-mbt-f\Provengo\Moodle"                        # folder containing backup data and mysql
$startMoodle = "C:\Users\Denis\Documents\GitHub\2025-mbt-f\Provengo\Moodle\Start Moodle.exe"        # start Moodle server executable
$stopMoodle = "C:\Users\Denis\Documents\GitHub\2025-mbt-f\Provengo\Moodle\Stop Moodle.exe"          # stop Moodle server executable

# Stop the Moodle server
Write-Output "Stopping the Moodle server..."
& $stopMoodle
Start-Sleep -Seconds 15  # Wait for 15 seconds to ensure the server is fully stopped

# Reset the moodledata folder
Write-Output "Resetting the moodledata folder..."

# Check if the backup moodledata folder exists
if (Test-Path "$backupFolder\moodledata") {
    Write-Output "Backup folder found: $backupFolder\moodledata"
    
    # Remove the current moodledata folder if it exists
    if (Test-Path $moodleDataFolder) {
        Write-Output "Removing existing moodledata folder..."
        Remove-Item -Recurse -Force $moodleDataFolder  # Remove current moodledata folder
    }
    
    Write-Output "Copying new moodledata from backup..."
    Copy-Item -Recurse -Force "$backupFolder\moodledata" $moodleDataFolder
    Write-Output "moodledata folder has been successfully copied."
} else {
    Write-Output "Backup moodledata folder does not exist: $backupFolder\moodledata"
}

# Reset the mysql folder
Write-Output "Resetting the mysql folder..."

# Check if the backup mysql folder exists
if (Test-Path "$backupFolder\mysql") {
    Write-Output "Backup folder found: $backupFolder\mysql"
    
    # Remove the current mysql folder if it exists
    if (Test-Path $mysqlFolder) {
        Write-Output "Removing existing mysql folder..."
        Remove-Item -Recurse -Force $mysqlFolder  # Remove current mysql folder
    }
    
    Write-Output "Copying new mysql data from backup..."
    Copy-Item -Recurse -Force "$backupFolder\mysql" $mysqlFolder
    Write-Output "mysql folder has been successfully copied."
} else {
    Write-Output "Backup mysql folder does not exist: $backupFolder\mysql"
}

# Start the Moodle server
Write-Output "Starting the Moodle server..."
& $startMoodle
Start-Sleep -Seconds 15  # Wait for 15 seconds to allow the server to fully start

Write-Output "Moodle server has been reset and restarted successfully!"
