import java.util.List;
import org.eclipse.jgit.diff.DiffEntry;
import org.eclipse.jgit.diff.DiffEntry.ChangeType;

	private final RevCommit commit;

	private DiffEntry diffEntry;

		List<DiffEntry> entries = DiffEntry.scan(walk);

		for (DiffEntry entry : entries) {
			final FileDiff d = new FileDiff(commit, entry);
			r.add(d);
	 * @param gitFormat
	 *            if false, do not show any source or destination prefix,
	 *            and the paths are calculated relative to the eclipse
	 *            project, otherwise relative to the git repository
			final DiffFormatter diffFmt, boolean gitFormat) throws IOException {
		if (gitFormat) {
			diffFmt.setRepository(db);
			diffFmt.format(diffEntry);
			return;
		}

		outputEclipseDiff(d, db, diffFmt);
	}

	private void outputEclipseDiff(final StringBuilder d, final Repository db,
			final DiffFormatter diffFmt) throws IOException {
		if (!(getBlobs().length == 2))
		String projectRelativePath = getProjectRelativePath(db, getPath());
		d.append("diff --git ").append(projectRelativePath).append(" ") //$NON-NLS-1$ //$NON-NLS-2$
			.append(projectRelativePath).append("\n"); //$NON-NLS-1$
		final ObjectId id1 = getBlobs()[0];
		final ObjectId id2 = getBlobs()[1];
		final FileMode mode1 = getModes()[0];
		final FileMode mode2 = getModes()[1];
			d.append(getProjectRelativePath(db, getPath()));
			d.append(getProjectRelativePath(db, getPath()));
	private String getProjectRelativePath(Repository db, String repoPath) {
	public RevCommit getCommit() {
		return commit;
	}
	public String getPath() {
		if (ChangeType.DELETE.equals(diffEntry.getChangeType()))
			return diffEntry.getOldPath();
		return diffEntry.getNewPath();
	}
	public String getChange() {
		return diffEntry.getChangeType().name();
	}
	public ObjectId[] getBlobs() {
		List<ObjectId> objectIds = new ArrayList<ObjectId>();
		if (diffEntry.getOldId() != null)
			objectIds.add(diffEntry.getOldId().toObjectId());
		if (diffEntry.getNewId() != null)
			objectIds.add(diffEntry.getNewId().toObjectId());
		return objectIds.toArray(new ObjectId[]{});
	}
	public FileMode[] getModes() {
		List<FileMode> modes = new ArrayList<FileMode>();
		if (diffEntry.getOldMode() != null)
			modes.add(diffEntry.getOldMode());
		if (diffEntry.getOldMode() != null)
			modes.add(diffEntry.getOldMode());
		return modes.toArray(new FileMode[]{});
	}
	FileDiff(final RevCommit c, final DiffEntry entry) {
		diffEntry = entry;